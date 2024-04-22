package org.zerock.springex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Positive
    @Min(value = 1)
    @Builder.Default
    private int page = 1;

    @Positive
    @Min(value = 10)
    @Max(value = 100)
    @Builder.Default
    private int size = 10;


    public int getSkip() {
        return (page - 1) * size;
    }


}
