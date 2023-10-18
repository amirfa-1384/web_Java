package com.shop.demo.service;


import com.shop.demo.controller.Dto.Cart.AddToCartRepositoryDto;
import com.shop.demo.controller.Dto.Cart.CreatCartRepositoryRequestDto;
import com.shop.demo.controller.Dto.Cart.DeleteCartRepositoryDto;

import com.shop.demo.exception.NotFoundException;
import com.shop.demo.model.Cart;
import com.shop.demo.model.Products;
import com.shop.demo.model.User;
import com.shop.demo.repositoey.CartRepository;
import com.shop.demo.repositoey.ProductsRepository;
import com.shop.demo.repositoey.UserRepository;
import com.shop.demo.service.Dto.CartDto;
import com.shop.demo.util.CartDtoMapper;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.Set;

@Service
@AllArgsConstructor
public class CartService {

    private final CartDtoMapper mapper;
    private final UserRepository userRepository;
    private final ProductsRepository productsRepository;
    private final CartRepository cartRepository;

    //------------------------------------------------

    public CartDto creat(CreatCartRepositoryRequestDto request) {
        User user = userRepository.findById(request.getUser())
                .orElseThrow(NotFoundException::new);


        Cart cart = new Cart();
        cart.setUser(user);
        Cart savedPost=cartRepository.save(cart);
        return mapper.cartDto(user,savedPost);
    }


    //------------------------------------------------


    public void add(AddToCartRepositoryDto request) {
        Cart cart=cartRepository.findById(request.getCartId())
                .orElseThrow(NotFoundException::new);

        Products product = productsRepository.findById(request.getProductId())
                .orElseThrow(NotFoundException::new);


        Long inventory=mapper.CheckInventory(request);

        product.setInventory(inventory);
        productsRepository.save(product);

        Set<Products> set2=cart.getProducts();
        set2.add(product);
        /*cart.setProducts(mapper.addToList(product));*/
        cartRepository.save(cart);
    }

    //------------------------------------------------

    public void remove(DeleteCartRepositoryDto delete) {
        Cart cart=cartRepository.findById(delete.getCartId())
                .orElseThrow(NotFoundException::new);

        Products product=productsRepository.findById(delete.getProductId())
                .orElseThrow(NotFoundException::new);

        Set<Products> products=cart.getProducts();
/*        Products product1=mapper.findProduct(products,delete.getProductId());*/

        products.remove(product);
        cartRepository.save(cart);
    }


    //------------------------------------------------

    public Set<Products> getAll(Long userID) {
        Cart cart=cartRepository.findByUser(userID)
                .orElseThrow(NotFoundException :: new);

        Set<Products> listOfProducts=cart.getProducts();

        return listOfProducts;
    }
}
