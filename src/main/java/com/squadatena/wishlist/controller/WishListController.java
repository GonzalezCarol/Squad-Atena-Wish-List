package com.squadatena.wishlist.controller;


import com.squadatena.wishlist.entity.Product;
import com.squadatena.wishlist.entity.WishList;
import com.squadatena.wishlist.service.WishListService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api")
@RestController

public class WishListController {


    @Autowired
    private WishListService wishlistService;

    // Find a wishlist from a given client Id
    @ApiOperation(value = "Find a wishlist from a given client Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Client found", response = Response.class),
            @ApiResponse(code = 404, message = "Client not found", response = Response.class)
    })

    @GetMapping("/wishlist/{id_cliente}")
    public ResponseEntity<?> index(@PathVariable Long id_cliente) {
        try {
            return new ResponseEntity<>(wishlistService.wishListByCId(id_cliente), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    // Add a product in a given client wishlist
    @ApiOperation(value = "Add a product in a given client wishlist")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Client added", response = Response.class),
            @ApiResponse(code = 400, message = "Client not added", response = Response.class)
    })

    @PostMapping("/wishlist/add/{id_cliente}")
    public ResponseEntity<?> addProductWishlist(@RequestBody Long id_product, @PathVariable Long id_cliente) {
        try {
            WishList wishListAnswer = wishlistService.addProduct(id_cliente, id_product);
            return new ResponseEntity<>(wishListAnswer, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    // Delete a product in a given client wishlist
    @ApiOperation(value = "Delete a product in a given client wishlist")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Client deleted", response = Response.class),
            @ApiResponse(code = 400, message = "Client not deleted", response = Response.class)
    })

    @DeleteMapping("/wishlist/delete/{id_cliente}")
    public ResponseEntity<?> deleteProductWishlist(@RequestBody Long id_product, @PathVariable Long id_cliente) {
        try{
            WishList wishListAnswer = wishlistService.deleteProduct(id_cliente, id_product);
            return new ResponseEntity<>(wishListAnswer, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    // Find a product in a given client wishlist by the product name
    @ApiOperation(value = "Find a product in a given client wishlist by the product name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product found", response = Response.class),
            @ApiResponse(code = 404, message = "Product not found", response = Response.class)
    })

    @GetMapping("/wishlist/find/{id_cliente}")
    public ResponseEntity<?> findProductWishlist(@RequestBody String nameProduct, @PathVariable Long id_cliente) {
        try{
            Product productAnswer = wishlistService.productInAWishList(id_cliente,nameProduct);
            return new ResponseEntity<>(productAnswer, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}



