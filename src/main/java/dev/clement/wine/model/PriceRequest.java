package dev.clement.wine.model;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record PriceRequest(@NotNull(message = "idWine field is mandatory")
                           Integer idWine,
                           @NotNull(message = "idSite field is mandatory")
                           Integer idSite,
        @NotNull(message = "Amount field is mandatory")
                           Float amount,
                           @NotNull(message = "Date field is mandatory")
                           LocalDate date) {
}
