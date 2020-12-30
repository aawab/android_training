Requirements

1. The LoginActivity must have a place for the user to enter their email address
2. The LoginActivity must have a place for the user to enter their password
3. The LoginActivity must not display the password in plain text
4. The LoginActivity must have a login button that displays the text "Login"
5. The LoginActivity must have a way to display an error message to the user
6. When the login button is clicked, the activity should check that the password is at least 8
characters long and display the error message "The provided password is too short" if the
password is too short
7. When the login button is clicked, the activity should check that the password is not all spaces
and display the error message "The provided password is invalid" if the password is all spaces
8. When the login button is clicked, the activity should check that the email address: a) has an
"@" sign, b) has at least 1 character before the "@" sign, and c) has at least 3 characters,
including a "." after the "@" sign
9. If any of the rules from #8 are violated, the LoginActivity should display the error message
"Invalid email address"
10.The LoginActivity must have a way to display a success message (can be the same
mechanism used to display the error message)
11.If the email address and password are valid, the success message "Login success" should be
displayed
