package moyeora.myapp.controller;

import lombok.RequiredArgsConstructor;
import moyeora.myapp.annotation.LoginUser;
import moyeora.myapp.service.CommentService;
import moyeora.myapp.service.PostService;
import moyeora.myapp.service.SchoolUserService;
import moyeora.myapp.service.UserService;
import moyeora.myapp.util.FileUploadHelper;
import moyeora.myapp.vo.SchoolUser;
import moyeora.myapp.vo.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Controller
@RequestMapping("schoolUser")
public class SchoolUserController {

    //  private static final Log log = LogFactory.getLog(PostController.class);
    private final PostService postService;

    @Autowired
    private final SchoolUserService schoolUserService;
    private final FileUploadHelper fileUploadHelper;
    private final CommentService commentService;

    @Autowired
    private UserService userService;
    private String uploadDir = "post/";
    private static final Log log = LogFactory.getLog(SchoolUserController.class);

    @Value("${ncp.storage.bucket}")
    private String bucketName;


    @PostMapping("/addSchoolUser")
    @ResponseBody
    public String addSchoolUser(
            @LoginUser User loginUser,
            @RequestParam("schoolNo") int schoolNo) throws Exception {

        try {
            User user = userService.getUserInfo(loginUser.getNo());
            if (user == null) {
                return "error: 유저를 찾을 수 없습니다.";
            }

            // 스쿨 유저 추가
            SchoolUser schoolUser = new SchoolUser();
            schoolUser.setUserNo(loginUser.getNo());
            schoolUser.setSchoolNo(schoolNo);
            schoolUser.setLevelNo(5);

            schoolUserService.addSchoolUser(user.getNo(), schoolNo, schoolUser.getLevelNo());

            return "pending: 스쿨 가입이 신청이 완료되었습니다.";
        } catch (Exception e) {
            e.printStackTrace();
            return "error: 스쿨 가입 중 오류가 발생했습니다.";
        }
    }


}



