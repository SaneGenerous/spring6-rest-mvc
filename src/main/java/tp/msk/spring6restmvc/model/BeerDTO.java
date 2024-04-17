package tp.msk.spring6restmvc.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Builder
public class BeerDTO {
    private UUID id;
    private Integer version;
    @NotBlank
    @NotNull
    private String beerName;

    @NotNull
    private BeerStyle beerStyle;

    @NotNull
    @NotBlank
    private String ups;
    private Integer quantityInHand;

    @NotNull
    private BigDecimal price;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
