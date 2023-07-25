package dev.clement.wine.service;

import dev.clement.wine.entity.*;
import dev.clement.wine.model.WineReviewAverageRequest;
import dev.clement.wine.model.WineReviewAverageResponse;
import dev.clement.wine.repository.WineRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WineServiceTest {

    @InjectMocks
    private WineService wineService;

    @Mock
    private WineRepository wineRepository;

    @Test
    void addAdvantagesToService_should_save_advantage_to_service() {
        //GIVEN
        var client = new Client("test@gmail.com", "Jean", "Dupont", "0123456789");
        var site = new Site("Les vins", "www.vin.com");

        var wine2021 = new Wine("Chateau TOLOSA", "2021", 10.0f, "Rouge");
        var price2021Tolosa = new Price(5.50f, LocalDate.now(), wine2021, site);
        var price2021Tolosa2 = new Price(6.50f, LocalDate.now().minusMonths(6), wine2021, site);
        wine2021.setPrices(List.of(price2021Tolosa, price2021Tolosa2));
        var review2021Tolosa1 = new Review(4.00f, "Bien", wine2021, client);
        var review2021Tolosa2 = new Review(5.00f, "Super", wine2021, client);
        wine2021.setReviews(List.of(review2021Tolosa1, review2021Tolosa2));

        var wine2022 = new Wine("Chateau TOLOSA", "2022", 10.0f, "Rouge");
        var price2022Tolosa = new Price(4.50f, LocalDate.now(), wine2022, site);
        wine2022.setPrices(List.of(price2022Tolosa));
        wine2022.setReviews(List.of());

        var wine2023 = new Wine("Chateau TOLOSA", "2023", 10.0f, "Rouge");
        var price2023Tolosa = new Price(8.50f, LocalDate.now(), wine2022, site);
        wine2023.setPrices(List.of(price2023Tolosa));
        var review2023Tolosa1 = new Review(4.00f, "Bien", wine2023, client);
        var review2023Tolosa2 = new Review(5.00f, "Super", wine2023, client);
        var review2023Tolosa3 = new Review(5.00f, "Super", wine2023, client);
        wine2023.setReviews(List.of(review2023Tolosa1, review2023Tolosa2, review2023Tolosa3));

        //WHEN
        when(wineRepository.findWinesWithPricesBetweenLowerAndUpperRange(5.00f, 9.00f))
                .thenReturn(List.of(wine2021, wine2023));

        var response = wineService.getAllWinesReviewedOrderedByAverageDesc(new WineReviewAverageRequest(5.00f, 9.00f));

        //THEN
        var expected = List.of(new WineReviewAverageResponse(wine2021.getName(), wine2021.getYear(), 4.50f),
                new WineReviewAverageResponse(wine2023.getName(), wine2023.getYear(), 4.6666665f));
        assertThat(response.wines()).isEqualTo(expected);
    }

}
