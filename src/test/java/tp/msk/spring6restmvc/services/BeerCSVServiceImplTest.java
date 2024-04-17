package tp.msk.spring6restmvc.services;

import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;
import tp.msk.spring6restmvc.model.BeerCSVRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BeerCSVServiceImplTest {
    BeerCSVService beerCSVService = new BeerCSVServiceImpl();

    @Test
    void convertCSV() throws FileNotFoundException {

        File file = ResourceUtils.getFile("classpath:csvdata/beers.csv");

        List<BeerCSVRecord> recs = beerCSVService.convertCSV(file);

        System.out.println(recs.size());

        assertThat(recs.size()).isGreaterThan(0);
    }
}
