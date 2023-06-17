package pl.pollub.integration.industry.domain;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class IndustryHubRepository implements PanacheRepositoryBase<IndustryHub, UUID> {


}
