package com.factorIt.ecommerce.services;

import com.factorIt.ecommerce.dtos.ItemsCartDTO;
import com.factorIt.ecommerce.dtos.NewCartDTO;
import com.factorIt.ecommerce.entities.Cart;
import com.factorIt.ecommerce.entities.Product;
import com.factorIt.ecommerce.entities.User;
import com.factorIt.ecommerce.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

@Transactional
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    ProductService productService;

    @Autowired
    CartRepository cartRepository;

    @Override
    public void addToNewCart(NewCartDTO newCartDTO, User user) {

        Product product = productService.findProductById(newCartDTO.getProductId());
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setCreatedDate(LocalDateTime.now());
        cart.setEnded(false);
        cart.setProduct(product);
        cart.setQuantity(newCartDTO.getQuantity());
        cartRepository.save(cart);

    }

    @Override
    public void deleteFromCart(User user, Product product) {
        cartRepository.deleteByUserAndProductAndIsEnded(user, product, false);
    }

    @Override
    public List<ItemsCartDTO> getItemsFromUser(User user) {
        List<Cart> carts = cartRepository.findByUserAndIsEnded(user, false);
        return carts.stream().map(ItemsCartDTO::new).collect(Collectors.toList());
    }

    /*@Override
    public boolean isSpecial(User user) {
        List<Cart> cartType = cartRepository.findEndedCartsByUserByCreatedDate(user, false);

        if (!cartType.isEmpty()) {
            return cartType.get(0).isSpecial();
        }

        return true;
    }

    @Override
    public boolean isVip(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isVip'");
    }

    @Override
    public boolean isCommon(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isCommon'");
    }
*/
    @Override
    public void finishCarrt(User user) {
        cartRepository.endCart(user);
    }
}
