package judge.services;

import judge.domain.entities.Problem;
import judge.domain.entities.Submission;
import judge.domain.models.binding.CreateProblemBindingModel;
import judge.domain.models.service.ProblemServiceModel;
import judge.domain.models.view.DetailsProblemViewModel;
import judge.domain.models.view.HomeProblemViewModel;
import judge.repositories.ProblemRepository;
import judge.util.ModelValidator;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemServiceImpl implements ProblemService {

    private final ProblemRepository problemRepository;
    private final ModelMapper mapper;

    @Inject
    public ProblemServiceImpl(ProblemRepository problemRepository, ModelMapper mapper) {
        this.problemRepository = problemRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean create(CreateProblemBindingModel model) {
        if (!ModelValidator.isValid(model)) {
            return false;
        }

        this.problemRepository.save(this.mapper.map(model, Problem.class));
        return true;
    }

    @Override
    public DetailsProblemViewModel findDetailsModelById(String id) {
        DetailsProblemViewModel model = this.mapper.map(this.problemRepository.findByIdWithSubmissions(id), DetailsProblemViewModel.class);
        final int[] maxPointsSubmissionCount = {0};

        model.setSubmissions(model.getSubmissions().parallelStream()
                .peek(sub -> {
                    if (sub.getAchievedResult().equals(model.getPoints())) {
                        maxPointsSubmissionCount[0]++;
                    }
                    Integer percentage = (sub.getAchievedResult() * 100) / model.getPoints();
                    sub.setAchievedPercentage(percentage);
                })
                .collect(Collectors.toList()));

        model.setSuccessRate(((double) maxPointsSubmissionCount[0] / model.getSubmissions().size()) * 100);
        if (model.getSuccessRate().isNaN()) model.setSuccessRate(0d);
        return model;
    }

    @Override
    public ProblemServiceModel getProblemById(String id) {
        return this.mapper.map(this.problemRepository.findOne(id), ProblemServiceModel.class);
    }

    @Override
    public String getProblemNameById(String id) {
        return this.problemRepository.findOne(id).getName();
    }

    @Override
    public List<HomeProblemViewModel> findAll(String userId) {
        return this.problemRepository.findAllWithUserSubmissions().parallelStream()
                .map(problem -> {
                    HomeProblemViewModel model = this.mapper.map(problem, HomeProblemViewModel.class);
                    int userAchievedResult = 0;
                    for (Submission submission : problem.getSubmissions()) {
                        if (submission.getUser().getId().equals(userId) && submission.getAchievedResult() > userAchievedResult) {
                            userAchievedResult = submission.getAchievedResult();
                        }
                    }

                    model.setCompletion((userAchievedResult * 100) / problem.getPoints());
                    return model;
                })
                .collect(Collectors.toList());
    }
}
