# toolshare
Toolshare is my proprietary web application for managing responsibility for qr-coded tools.  
Tech stack: Java, Spring, Hibernate, H2, JSON, Maven other.

## how it works
A user comes to a person currently resposible for a tool (regular user or tool manager), scans a qr code of the tool, taking responsibility for it from now on.  
Returning the tool: tool is returned when another user scans a tool currently rented by you - it may be another user or manager.

Administrator's role is to add or delete manager accounts.

## beta version available under:
http://ec2-18-195-169-134.eu-central-1.compute.amazonaws.com:8081/  

###    log in as:
administrator:
```
username: a
password: a
```  
manager:
```
username: b
password: b
```  
user:
```
username: userc
password: c
```  

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
