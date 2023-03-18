package crudrestapi.crudrestapi.view.controller;

import crudrestapi.crudrestapi.services.ProductService;
import crudrestapi.crudrestapi.shared.ProductDTO;
import crudrestapi.crudrestapi.view.model.ProductRequest;
import crudrestapi.crudrestapi.view.model.ProductResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<ProductResponse>> findAll() {

        List<ProductDTO> products = productService.findAll();

        ModelMapper mapper = new ModelMapper();

        List<ProductResponse> response = products.stream()
                .map(ProductDTO -> mapper.map(ProductDTO, ProductResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductResponse>> findById(@PathVariable Integer id) {

        Optional<ProductDTO> dto = productService.findById(id);

        ProductResponse product = new ModelMapper().map(dto.get(), ProductResponse.class);

        return new ResponseEntity<>(Optional.of(product), HttpStatus.OK);
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest) {

        ModelMapper mapper = new ModelMapper();

        ProductDTO productDTO = mapper.map(productRequest, ProductDTO.class);

        productDTO = productService.addProduct(productDTO);

        return new ResponseEntity<>(mapper.map(productDTO, ProductResponse.class), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        productService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ProductResponse> update(@RequestBody ProductRequest productRequest,
            @PathVariable Integer id) {
        ModelMapper mapper = new ModelMapper();

        ProductDTO productDTO = mapper.map(productRequest, ProductDTO.class);

        productDTO = productService.update(id, productDTO);

        return new ResponseEntity<>(mapper.map(productDTO, ProductResponse.class), HttpStatus.OK);
    }
}
