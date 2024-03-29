package demo.webflux.adapters.ui.user

import demo.webflux.application.usecases.user.service.UserService
import demo.webflux.ports.input.UserRequest
import demo.webflux.ports.output.UserResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/v1/user")
@Tag(name = "UserController", description = "사용자 관련 API")
class UserController(private val userService: UserService) {
    /**
     * 사용자 등록
     * @param userRequest(username, password)
     * @return userResponse (username, password)
     */
    @PostMapping("/signup")
    @Operation(summary = "사용자 등록", description = "새로운 사용자를 등록합니다.")
    fun signup(
        @RequestBody userRequest: UserRequest,
    ): Mono<UserResponse> {
        return userService.save(userRequest)
    }

    /**
     * 로그인
     * @param userRequest(username, password)
     * @return userResponse (username, token)
     */
    @PostMapping("/login")
    @Operation(summary = "로그인", description = "사용자 로그인을 수행하고 토큰을 반환합니다.")
    fun login(
        @RequestBody userRequest: UserRequest,
    ): Mono<UserResponse> {
        return userService.login(userRequest)
    }
}
