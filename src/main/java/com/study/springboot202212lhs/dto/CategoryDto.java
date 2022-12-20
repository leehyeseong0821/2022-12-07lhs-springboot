package com.study.springboot202212lhs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryDto {

   private int categoryId;
   private String categoryName;
   private String categoryOpt1;
   private String categoryOpt2;
}
