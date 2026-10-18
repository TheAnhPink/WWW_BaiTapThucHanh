package iuh.fit.demospringdatamongodb.resource;

import iuh.fit.demospringdatamongodb.model.Position;
import iuh.fit.demospringdatamongodb.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionResource {
    private final CompanyService companyService;

    public PositionResource(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Position> getAll() {
        return companyService.getAllPositions();
    }
}