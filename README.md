# Telephone-Directory

### Description
This project aims to create and maintain a telephone directory having records of users and their phone numbers.

The basic functionalities are :
- Add a new record
- View the phone number corresponding to a record name
- Modify the phone number of an existing record
- View all records in the database
- Delete a record
- Clear text fields
The user-inputs are also checked for invalid entries.
The records are maintained in a Java properties file.

### Key Learnings
- Learning Java Swing from scratch
- Learning the concept of Java Properties files
- Handling Java I/O (Input/Output)

### Images
#### The first screen
![alt text](https://github.com/Meghna180401/Telephone-Directory/blob/main/Images/first-screen.png)

#### Add records : Adds a name and a phone number. Shows an alert for invalid or duplicate entries.
![alt text](https://github.com/Meghna180401/Telephone-Directory/blob/main/Images/add-record-valid.png)

#### View record : Displays phone number against corresponding name. Shows an alert for invalid or non-existential entries.
![alt text](https://github.com/Meghna180401/Telephone-Directory/blob/main/Images/view-record.png)

#### Modify record : Modifies phone number against corresponding name. Shows an alert for invalid or non-existential entries.
![alt text](https://github.com/Meghna180401/Telephone-Directory/blob/main/Images/modify-1.png)
![alt text](https://github.com/Meghna180401/Telephone-Directory/blob/main/Images/modify-2.png)

#### View all records : Displays all records in the database. Shows alert for empty database.
![alt text](https://github.com/Meghna180401/Telephone-Directory/blob/main/Images/view-all.png)

### Delete record : Deletes a record with a given name. Shows an alert for invalid or non-existential entries.
![alt text](https://github.com/Meghna180401/Telephone-Directory/blob/main/Images/delete-1.png)
![alt text](https://github.com/Meghna180401/Telephone-Directory/blob/main/Images/delete-2.png)

### Clear Text : Cleares the input text fields
![alt text](https://github.com/Meghna180401/Telephone-Directory/blob/main/Images/clear.png)


### Limitations
- Since the frame size is set to be a fixed value, the number of records which can be viewed is limited. 
- View, Modify and Delete operations work against a corresponding user-name. They cannot work based on phone numbers.
- The GUI is very basic, as it is my first delve into Java Swing.
