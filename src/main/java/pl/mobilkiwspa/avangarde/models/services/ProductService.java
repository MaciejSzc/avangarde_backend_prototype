package pl.mobilkiwspa.avangarde.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mobilkiwspa.avangarde.models.entities.ProductEntity;
import pl.mobilkiwspa.avangarde.models.entities.ServeEntity;
import pl.mobilkiwspa.avangarde.models.forms.ProductForm;
import pl.mobilkiwspa.avangarde.models.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Iterable<ProductEntity> getAll(){
        return productRepository.findAll();
    }

    public void addProduct(ProductForm productForm){
        ProductEntity productEntity = new ProductEntity();

        productEntity.setName(productForm.getName());
        productEntity.setCount(productForm.getCount());

        productRepository.save(productEntity);
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
}
