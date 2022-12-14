package com.boostjava2.MonoliticCoding.service;

import com.boostjava2.MonoliticCoding.dto.request.ProductSaveRequestDto;
import com.boostjava2.MonoliticCoding.mapper.ProductMapper;
import com.boostjava2.MonoliticCoding.repostiory.ProductRepository;
import com.boostjava2.MonoliticCoding.repostiory.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceManager<Product, Long> {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }
    public Product save(ProductSaveRequestDto dto){
        return productRepository.save(ProductMapper.INSTANCE.toProduct(dto));
    }

    public Product saveMapper(ProductSaveRequestDto dto){
        Product product = ProductMapper.INSTANCE.toProduct(dto);
        product.setCreateddate(System.currentTimeMillis());
        return productRepository.save(product);
    }


}

