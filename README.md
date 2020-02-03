# toolshare
Toolshare is a web application for managing responsibility for qr-coded tools.
Tech stack: Java, Spring, Hibernate, H2, JSON, other.

## how it works
User comes to the tool manager or a user currently renting a tool and scans a qr code of the tool and is responsible for it from now on.
Returning the tool: tool is returned when another user scans a tool currently rented by you thus transferring responsibility - it may be another user or manager.

Administrator's role is to add or delete manager accounts.

## administrator views
<img src="src\main\resources\static\img\readme\admin_home.png"> 
<img src="src\main\resources\static\img\readme\admin_managers.png"> 
<img src="src\main\resources\static\img\readme\admin_addManager.png"> 

## manager views
<img src="src\main\resources\static\img\readme\manager_items.png"> 
<img src="src\main\resources\static\img\readme\manager_item.png"> 
<img src="src\main\resources\static\img\readme\manager_user.png"> 

## user views
<img src="src\main\resources\static\img\readme\user_home.png"> 
<img src="src\main\resources\static\img\readme\user_rentals.png"> 
<img src="src\main\resources\static\img\readme\user_pastRentals.png"> 

## error pages
<img src="src\main\resources\static\img\readme\error_403.png"> 
<img src="src\main\resources\static\img\readme\error_404.png"> 
<img src="src\main\resources\static\img\readme\error_500.png"> 
<img src="src\main\resources\static\img\readme\error_unknown.png"> 
