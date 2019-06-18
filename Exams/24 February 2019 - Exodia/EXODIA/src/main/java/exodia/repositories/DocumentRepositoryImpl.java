package exodia.repositories;

import exodia.domain.entities.Document;

import javax.ejb.Stateless;

@Stateless
public class DocumentRepositoryImpl extends BaseCrudRepository<Document, String> implements DocumentRepository {
}
