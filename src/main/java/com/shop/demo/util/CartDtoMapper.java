package com.shop.demo.util;

import com.shop.demo.controller.Dto.Cart.AddToCartRepositoryDto;
import com.shop.demo.exception.NoInventoryException;
import com.shop.demo.exception.NotFoundException;
import com.shop.demo.model.Cart;
import com.shop.demo.model.Products;
import com.shop.demo.model.User;
import com.shop.demo.repositoey.ProductsRepository;
import com.shop.demo.service.Dto.CartDto;
import com.shop.demo.service.Dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class CartDtoMapper {

    private final ProductsRepository productsRepository;



    //------------------------------------------------
    public UserDto userDto(User request) {
        return UserDto.builder()
                .Id(request.getId())
                .email(request.getEmail())
                .build();
    }

    //------------------------------------------------

    public CartDto cartDto(User user, Cart cart) {
        return CartDto.builder()
                .user(userDto(user).getId())
                .cartId(cart.getId())
                .build();
    }

    //------------------------------------------------

        public Set<Products> addToList (Products product){

            Set<Products> list = new HashSet<>();

            list.add(product);

            return list;
        }

    //------------------------------------------------

        public Long CheckInventory(AddToCartRepositoryDto request){
            Products product=productsRepository.findById(request.getProductId())
                    .orElseThrow(NotFoundException::new);

            Long inventory=product.getInventory();

            if(request.getNum()>inventory){
                throw new NoInventoryException();
            }

            Long newInventory=inventory-request.getNum();
            return newInventory;
        }
}
