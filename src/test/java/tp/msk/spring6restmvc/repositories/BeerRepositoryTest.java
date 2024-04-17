package tp.msk.spring6restmvc.repositories;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import tp.msk.spring6restmvc.bootstrap.BootstrapData;
import tp.msk.spring6restmvc.entities.Beer;
import tp.msk.spring6restmvc.model.BeerStyle;
import tp.msk.spring6restmvc.services.BeerCSVServiceImpl;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DataJpaTest
@Import({BootstrapData.class, BeerCSVServiceImpl.class})
class BeerRepositoryTest {
    @Autowired
    BeerRepository beerRepository;

    @Test
    void getBeerListByName() {
        Page<Beer> list = beerRepository.findAllByBeerNameIsLikeIgnoreCase("%IPA%", null);

        assertThat(list.getContent().size()).isEqualTo(335);
    }

    @Test
    void testSaveBeerLongBeerName() {
        assertThrows(ConstraintViolationException.class, () -> {
            Beer savedBeer = beerRepository.save(Beer.builder()
                    .beerName("My Beer 1234567890123456789012345678901234567890123456789012345678901234567890")
                    .beerStyle(BeerStyle.STOUT)
                    .ups("3543543543")
                    .price(new BigDecimal("13.99"))
                    .build());

            beerRepository.flush();
        });
    }
    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                        .beerName("My Beer")
                        .beerStyle(BeerStyle.STOUT)
                        .ups("3543543543")
                        .price(new BigDecimal("13.99"))
                .build());

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}