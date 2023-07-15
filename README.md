# RestaurantApp

## Framework and language used 
* Spring Boot
* Java
---
## Data flow
1. controllers
    * FoodController
    * OrderController
    * UserController
2. models
     1. dto 
        * SignInInput
        *   SignUpOutput
    * AuthenticationToken 
    * Food
    * Order 
    * Status
    * user
3. services
    * AuthTokenService
    * FoodService
    * OrderService
    * UserService
4. repositories
    * IAuthtokenRepo
    * IFoodRepo
    * IOrderRepo
    * IUserRepo

---

## Data Structure Used
* MySQL
* Jpa

---

```Its a restauntrant management system application. all the stuff work with food, order and users. I have provide some authentication on user level and admin level. I have also provide the sign up and sign in functionalities in this project. project will create a token and provide the user whenever user signed in and destroy the token when user signed out. ```
