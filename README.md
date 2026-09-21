# Spring Security Login Demo

Project hoàn chỉnh chức năng Login với Spring Security 6.

## Tính năng
- Đăng nhập bằng **Username** hoặc **Email**
- `CustomUserDetails` → hiển thị fullName + avatar + role trên header
- Phân quyền USER / ADMIN
- H2 Database (chạy ngay)
- Không dùng Lombok / MapStruct → tương thích mọi JDK

## Tài khoản demo

| Username | Password | Role  |
|----------|----------|-------|
| user01   | 123456   | USER  |
| admin    | 123456   | ADMIN |

## Chạy project

```bash
mvn clean spring-boot:run
```

Mở: http://localhost:8080/login
