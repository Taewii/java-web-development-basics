package panda.web.beans.packets;

import lombok.NoArgsConstructor;
import panda.domain.models.binding.PackageCreateBindingModel;
import panda.domain.models.view.UserOptionViewModel;
import panda.services.PackageService;
import panda.services.UserService;
import panda.web.beans.BaseBean;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Model
@NoArgsConstructor
public class PackageCreateBean extends BaseBean {

    private PackageCreateBindingModel model = new PackageCreateBindingModel();
    private List<UserOptionViewModel> users = new ArrayList<>();

    private UserService userService;
    private PackageService packageService;

    @Inject
    public PackageCreateBean(UserService userService, PackageService packageService) {
        this.userService = userService;
        this.packageService = packageService;
    }

    @PostConstruct
    private void init() {
        this.users = this.userService.userOptionViewModels();
    }

    public void create() {
        this.packageService.create(this.model);
        super.redirect("/");
    }

    public PackageCreateBindingModel getModel() {
        return this.model;
    }

    public List<UserOptionViewModel> getUsers() {
        return Collections.unmodifiableList(this.users);
    }
}
