
1. Unit test là gì ?
  Hiểu đơn giản thì Unit test là phương pháp tiếp cận để test độc lập, 
    - tức là mỗi một chức chăng năng sẽ được đi kèm với một hoặc nhiều bài test 
    - để chắc chắn ràng cái chức năng đó hoạt động ổn. 

Do vậy, Unit Test  là đơn nhỏ nhất và vậy nên --> test case cũng dễ dàng khởi tạo vì nó là nhỏ nhất rồi.


2. Mở rộng ra hơn bài toán : 
   - Khi chúng ta phải test sự hoạt động phối hợp giữa nhiều chức năng 
     hoặc nhiều  thành phần với nhau
     hoặc muốn test một chức năng lớn 
   thì sẽ trở nên phức tạp và khó xây dựng test  hơn rất nhiều.

Các kịch bản sau thường diễn ra:
    - Chức năng A gọi tới chức năng B. tuy nhiên, B chưa viết xong
    - Chức năng A gọi tới chức năng B. tuy nhiên, B khởi tạo rất phức tạp (truy xuất Database, yêu cầu nhiều params, v.v.)
    - Muốn test chức năng A, tuy nhiên A yêu cầu nỗ lực lớn của cả hệ thống (Yêu cầu có HTTP-server, authorize, v.v.)


 ==> Thực tế , Có rất nhiều kịch bản phức tạp xảy ra :
    chúng ta chỉ mong muốn confirm rằng A ổn, chứ thằng B, C, D gì đó thì hãy cứ tạm coi là nó "đã ổn" .

5. Để đơn giản hoá các kịch bản test như trên, khái niệm Mock ra đời.

   - Tư tưởng của  Mock đơn giản là khi muốn test (A gọi B) thì thay vì tạo ra một đối tượng B thật sự, 
   - Ta tạo ra một thằng B' giả mạo, có đầy đủ chức năng như B thật ( B' là face của B )

  Ta sẽ giả lập cho B' biết là khi thằng A gọi tới nó :
    - thì B' cần làm gì
    - và B' trả lại cái gì cho A ( ta hardcode). 
   --> Miễn làm sao cho nó trả ra đúng cái thằng A cần để chúng ta có thể test A thuận lợi nhất.

   Ví dụ :
    // Khi Phương thức get của API /v1/getList được gọi, hãy trả ra một List(1,2,3)
    Mockito.when(get("/v1/getList"))
           .thenReturn(Arrays.asList(1, 2, 3));
    
     Mockito chính là thư viện nổi tiếng nhất để ta  làm việc này.

https://loda.me/test-huong-dan-toan-tap-mockito-loda1576641016810/