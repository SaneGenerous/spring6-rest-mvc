package tp.msk.spring6restmvc.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tp.msk.spring6restmvc.model.BeerDTO;
import tp.msk.spring6restmvc.model.BeerStyle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    private final Map<UUID, BeerDTO> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        BeerDTO beerDTO1 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.PALE_ALE)
                .ups("123456")
                .price(new BigDecimal("12.99"))
                .quantityInHand(122)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        BeerDTO beerDTO2 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Crank")
                .beerStyle(BeerStyle.PALE_ALE)
                .ups("654321")
                .price(new BigDecimal("11.99"))
                .quantityInHand(110)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        BeerDTO beerDTO3 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Sunshine City")
                .beerStyle(BeerStyle.IPA)
                .ups("789987")
                .price(new BigDecimal("10.99"))
                .quantityInHand(130)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        beerMap.put(beerDTO1.getId(), beerDTO1);
        beerMap.put(beerDTO2.getId(), beerDTO2);
        beerMap.put(beerDTO3.getId(), beerDTO3);
    }

    @Override
    public Page<BeerDTO> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize) {
        return new PageImpl<>(new ArrayList<>(beerMap.values())) ;
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {
        log.debug("Get beer by Id - in service ID: " + id.toString());
        return Optional.of(beerMap.get(id));
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beerDTO) {
        BeerDTO savedBeerDTO = BeerDTO.builder()
                .id(UUID.randomUUID())
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .beerName(beerDTO.getBeerName())
                .ups(beerDTO.getUps())
                .version(beerDTO.getVersion())
                .beerStyle(beerDTO.getBeerStyle())
                .quantityInHand(beerDTO.getQuantityInHand())
                .price(beerDTO.getPrice())
                .build();

        beerMap.put(savedBeerDTO.getId(), savedBeerDTO);

        return savedBeerDTO;
    }

    @Override
    public Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beerDTO) {
        BeerDTO existing = beerMap.get(beerId);
        existing.setBeerName(beerDTO.getBeerName());
        existing.setBeerStyle(beerDTO.getBeerStyle());
        existing.setPrice(beerDTO.getPrice());
        existing.setQuantityInHand(beerDTO.getQuantityInHand());
        existing.setUps(beerDTO.getUps());
        existing.setVersion(beerDTO.getVersion());
        beerMap.put(existing.getId(), existing);
        return Optional.of(existing);
    }

    @Override
    public Boolean deleteBeerById(UUID beerId) {
        beerMap.remove(beerId);
        return true;
    }

    @Override
    public void patchBeerById(UUID beerId, BeerDTO beerDTO) {
        BeerDTO existing = beerMap.get(beerId);
        if (StringUtils.hasText(beerDTO.getBeerName())) {
            existing.setBeerName(beerDTO.getBeerName());
        }
        if (beerDTO.getBeerStyle() != null) {
            existing.setBeerStyle(beerDTO.getBeerStyle());
        }
        if (beerDTO.getPrice() != null) {
            existing.setPrice(beerDTO.getPrice());
        }
        if (beerDTO.getQuantityInHand() != null) {
            existing.setQuantityInHand(beerDTO.getQuantityInHand());
        }
        if (StringUtils.hasText(beerDTO.getUps())) {
            existing.setUps(beerDTO.getUps());
        }
    }
}
