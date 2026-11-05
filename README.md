# Homework Session 1: Say Hello (Hello World)

Ứng dụng Android Native hoàn thành theo yêu cầu bài tập **Session 1: The Android platform, Java for Android and application fundamentals** (Slide 39 - 44).

## 1. Yêu cầu đã thực hiện
- [x] Package name: `vn.edu.course.helloworld`, minSdk 26, targetSdk 36.
- [x] Giao diện gồm `greetingText`, `nameInput`, `sayHelloButton` căn chỉnh theo `ConstraintLayout` chuẩn.
- [x] Bật `ViewBinding` (`ActivityMainBinding`).
- [x] Kiểm tra ô nhập tên rỗng: hiển thị `Toast` nhắc nhở.
- [x] Lời chào động:
  - Chưa nhập: Hiển thị tên sinh viên & MSSV từ `strings.xml`.
  - Đã nhập: Hiển thị `Hello, <Tên>!`.
- [x] Lưu trạng thái xoay màn hình (orientation change) bằng `onSaveInstanceState` qua key `greeted_name`.
- [x] Ghi nhật ký vòng đời Activity (Lifecycle logs) ra Logcat (`onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onDestroy`).
- [x] Toàn bộ chuỗi văn bản được khai báo trong `res/values/strings.xml`.

## 2. Các bước mở và chạy trong Android Studio
1. Mở **Android Studio** -> Chọn **Open** -> Trỏ tới thư mục `HelloWorld`.
2. Đợi Gradle sync hoàn tất.
3. Chỉnh sửa Họ tên và MSSV của bạn trong file:
   `app/src/main/res/values/strings.xml`:
   ```xml
   <string name="student_name" translatable="false">Họ Và Tên Của Bạn</string>
   <string name="student_id" translatable="false">Mã_Số_Sinh_Viên</string>
   ```
4. Chọn máy ảo Android (Emulator) hoặc cắm thiết bị thật (bật USB Debugging).
5. Nhấn nút **Run** (Shift + F10 hoặc icon Play xanh).

## 3. Kiểm thử trên máy ảo
- Mở tab **Logcat** ở cạnh dưới, đặt filter: `package:mine tag:MainActivity`.
- Thử bấm nút **Say hello** khi chưa nhập tên -> Xem Toast hiện lên.
- Nhập tên -> Bấm **Say hello** -> Text hiển thị `Hello, <Tên>!`.
- Xoay màn hình (Rotate device `Ctrl + F11`) -> Tên vừa nhập và lời chào vẫn được giữ nguyên nhờ `savedInstanceState`.

## 4. Đẩy lên Git và nộp bài LMS
```bash
cd HelloWorld
git init
git add .
git commit -m "feat: complete Session 1 Hello World homework"
git branch -M main
git remote add origin <URL_REPO_GITHUB_CUA_BAN>
git push -u origin main
```
Chụp 1 ảnh màn hình app đang chạy kèm lời chào trên máy ảo để nộp lên LMS kèm link GitHub.
