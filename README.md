# chat

One on one chat build using Spring boot, Flyway, Postgresql, Data Jpa

To use this application you need first create user and customer support(named CS).
After that you will create room using their ids.
After that you can send messages.
Finally, you need to close the room so in the future conversation it won't be shown to users.
Each time new room opens users won't see their past conversations.
P.s. Do not forget to change application.properties file

Here are Postman request code snippets. Use them for testing(replace ids and other parameters with your input):

1. Creating new User.
   curl --location --request POST 'http://localhost:8080/newUser?name=doctor' \
   --data ''

2. Creating new Customer Support.
   curl --location --request POST 'http://localhost:8080/newCS?name=doctor' \
   --data ''

3. Sending Message.
   curl --location 'http://localhost:8080/send' \
   --header 'Content-Type: application/json' \
   --data '{
   "senderId": "f0cddfa8-d6be-4b4c-a584-6024b5613c56",
   "receiverId": "d4bec73f-7a5f-4973-89a3-60a77d01a58c",
   "content": "aesffs effe!",
   "roomId": "8ba25697-dc84-4d2c-a4f3-d09cedc352e0"
   }'

4. Creating new Room(before messaging you need to create room for users).
   curl --location --request
   POST 'http://localhost:8080/newRoom?staff=f0cddfa8-d6be-4b4c-a584-6024b5613c56&consumer=d4bec73f-7a5f-4973-89a3-60a77d01a58c'

5. Closing Room(it is done when conversation ended).
   curl --location --request POST 'http://localhost:8080/closeRoom?roomId=8ba25697-dc84-4d2c-a4f3-d09cedc352e0'

6. Getting messages in this room(if room is closed it won't return anything).
   curl --location 'http://localhost:8080/get?roomId=8ba25697-dc84-4d2c-a4f3-d09cedc352e0'


