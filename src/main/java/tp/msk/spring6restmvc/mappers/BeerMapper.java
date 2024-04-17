package tp.msk.spring6restmvc.mappers;

import org.mapstruct.Mapper;
import tp.msk.spring6restmvc.entities.Beer;
import tp.msk.spring6restmvc.model.BeerDTO;

@Mapper
public interface BeerMapper {
    Beer beerDTOtoBeer(BeerDTO beerDto);
    BeerDTO beerToBeerDTO(Beer beer);
}
