# hanghaeSpringBootHomework

|Method|URL|Request|Response|설명|
|:---|:---|:---|:---|:---|
|POST|/crud|{
    "username" : "ndk4343534",
    "password" : "1234",
    "title" : "title123",
    "contents" : "contents123"
    }|{
    "username": "ndk4343534",
    "password": "1234",
    "title": "title123",
    "contents": "contents123"
}|데이터 입력 후 입력된 데이터 반환|
|GET|/crud||[
    {
        "createdAt": "2023-02-08T13:43:53.953567",
        "modifiedAt": "2023-02-08T13:43:53.953567",
        "id": 1,
        "username": "ndk4343534",
        "password": "1234",
        "title": "title123",
        "contents": "contents123"
    }
]|데이터 전체 조회하여 반환|
|PUT|/crud/{id}|{
    "crudRequestDto":{
        "username" : "ndkPut",
        "password" : "1234",
        "title" : "titlePut",
        "contents" : "contentsPut"
    }
    ,
    "crudPasswordDto":{
        "password" : "1234"
    }
}|{id}번 게시물 수정 성공|인증용 비밀번호와 수정할 데이터를 받아 해당 id의 데이터 수정|
|DELETE|/crud/{id}|{
    "password" : "1234"
}|{id}번 게시물 삭제 성공|인증용 비밀번호를 받아 해당 id의 게시물 삭제|

Method	URL	Request	Response	설명
POST	/crud	"{
    ""username"" : ""ndk4343534"",
    ""password"" : ""1234"",
    ""title"" : ""title123"",
    ""contents"" : ""contents123""
    }"	"{
    ""username"": ""ndk4343534"",
    ""password"": ""1234"",
    ""title"": ""title123"",
    ""contents"": ""contents123""
}"	데이터 입력 후 입력된 데이터 반환
GET	/crud		"[
    {
        ""createdAt"": ""2023-02-08T13:43:53.953567"",
        ""modifiedAt"": ""2023-02-08T13:43:53.953567"",
        ""id"": 1,
        ""username"": ""ndk4343534"",
        ""password"": ""1234"",
        ""title"": ""title123"",
        ""contents"": ""contents123""
    }
]"	데이터 전체 조회하여 반환
PUT	/crud/{id}	"{
    ""crudRequestDto"":{
        ""username"" : ""ndkPut"",
        ""password"" : ""1234"",
        ""title"" : ""titlePut"",
        ""contents"" : ""contentsPut""
    }
    ,
    ""crudPasswordDto"":{
        ""password"" : ""1234""
    }
}"	{id}번 게시물 수정 성공	인증용 비밀번호와 수정할 데이터를 받아 해당 id의 데이터 수정
DELETE	/crud/{id}	"{
    ""password"" : ""1234""
}"	{id}번 게시물 삭제 성공	인증용 비밀번호를 받아 해당 id의 게시물 삭제
![image](https://user-images.githubusercontent.com/81396553/217442608-91dacf9a-4af6-404f-8e83-482ee750217b.png)

