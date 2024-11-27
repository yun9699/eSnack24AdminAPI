package org.esnack24api.esnack24adminapi.product.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.esnack24api.esnack24adminapi.common.page.PageRequest;
import org.esnack24api.esnack24adminapi.common.page.PageResponse;
import org.esnack24api.esnack24adminapi.product.dto.ProductAllergyListDTO;
import org.esnack24api.esnack24adminapi.product.dto.ProductDetailDTO;
import org.esnack24api.esnack24adminapi.product.dto.ProductListDTO;
import org.esnack24api.esnack24adminapi.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
@PreAuthorize("permitAll()")
@RequestMapping("admin/api/v1/product")
public class ProductController {

    private final ProductService productService;

    // 상품 리스트 조회
    @GetMapping("list")
    public ResponseEntity<PageResponse<ProductListDTO>> getProductList(PageRequest pageRequest) {
        log.info("Get ProductList");

        return ResponseEntity.ok(productService.getProductList(pageRequest));
    }

    // 상품 알레르기 리스트 조회
    @GetMapping("/allergylist")
    public ResponseEntity<PageResponse<ProductAllergyListDTO>> productAllergyList(PageRequest pageRequest) {
        log.info("Get ProductAllergyList");

        return ResponseEntity.ok(productService.getProductAllergyList(pageRequest));
    }

    // 상품 상세 조회
    @GetMapping("/detail/{pno}")
    public ResponseEntity<ProductDetailDTO> getProductOne(@PathVariable Long pno) {
        log.info("Get Product Detail - pno: " + pno);
        return ResponseEntity.ok(productService.getProductOne(pno));
    }
}
