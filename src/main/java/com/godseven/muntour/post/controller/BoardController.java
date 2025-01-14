package com.godseven.muntour.post.controller;
//
//import com.godseven.muntour.auth.MemberRepository;
//import com.godseven.muntour.member.domain.Member;
//import com.godseven.muntour.post.dto.BoardRequest;
//import com.godseven.muntour.post.dto.BoardDto;
////import com.godseven.muntour.post.repository.MemberRepository;
//import com.godseven.muntour.post.dto.PostDto;
//import com.godseven.muntour.post.service.BoardService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
////import org.springframework.security.core.Authentication;
////import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//@RequiredArgsConstructor
//@RestController
//public class BoardController {
//    private final BoardService boardService;
//    private final MemberRepository memberRepository;
//
//    // 전체 게시글 조회
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/boards")
//    public ResponseEntity<ApiResponse> getBoards() {
//        return ResponseEntity.ok(new ApiResponse("성공", "전체 게시물 리턴", boardService.getBoards()));
//    }
//
//    // 게시글 조회
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/boards/{id}")
//    public ResponseEntity<ApiResponse> getBoard(@PathVariable("id") Integer id) {
//        return ResponseEntity.ok(new ApiResponse("성공", "개별 게시물 리턴", boardService.getBoard(id)));
//    }
//
////    // 게시글 작성
////    @ResponseStatus(HttpStatus.CREATED)
////    @PostMapping("/boards/write")
////    public ResponseEntity<ApiResponse> write(@RequestBody BoardRequest boardRequest, Authentication authentication) {
////        Member member = getAuthenticatedMember(authentication);
////        BoardDto boardDto = boardRequest.toDto();
////        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("성공", "글 작성 성공", boardService.write(boardDto, member, boardRequest.getTags())));
////    }
////
////    // 게시글 수정
////    @ResponseStatus(HttpStatus.OK)
////    @PutMapping("/boards/update/{id}")
////    public ResponseEntity<ApiResponse> edit(@RequestBody BoardRequest boardRequest, @PathVariable("id") Integer id, Authentication authentication) {
////        Member member = getAuthenticatedMember(authentication);
////        BoardDto boardDto = boardRequest.toDto();
////        return ResponseEntity.ok(new ApiResponse("성공", "글 수정 성공", boardService.update(id, boardDto, boardRequest.getTags())));
////    }
//
//    // 게시글 삭제
//    @ResponseStatus(HttpStatus.OK)
//    @DeleteMapping("/boards/delete/{id}")
//    public ResponseEntity<ApiResponse> delete(@PathVariable("id") Integer id) {
//        boardService.delete(id);
//        return ResponseEntity.ok(new ApiResponse("성공", "글 삭제 성공", null));
//    }
//
//    // 게시글 검색
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/boards/search")
//    public ResponseEntity<ApiResponse> searchBoards(@RequestParam("keyword") String keyword) {
//        return ResponseEntity.ok(new ApiResponse("성공", "검색 결과 리턴", boardService.searchBoards(keyword)));
//    }
//
////    // 인증된 사용자 정보를 가져오는 메서드
////    private Member getAuthenticatedMember(Authentication authentication) {
////        String nickname = getNicknameFromAuthentication(authentication);
////        return memberRepository.findByNickname(nickname).orElseThrow(() -> new RuntimeException("Member not found"));
////    }
////
////    private String getNicknameFromAuthentication(Authentication authentication) {
////        if (authentication.getPrincipal() instanceof UserDetails) {
////            return ((UserDetails) authentication.getPrincipal()).getUsername(); // 여기서 username은 실제로 닉네임으로 매핑됩니다.
////        } else {
////            return authentication.getPrincipal().toString();
////        }
////    }
//
//
//    //카테고리
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/boards/category")
//    public ResponseEntity<ApiResponse> getCategoryList(@RequestParam(name = "category") String category) {
//        return ResponseEntity.ok(new ApiResponse("성공", "전체 게시물 리턴", boardService.getCategoryBoards(category)));
//    }
//
//    //new!! 해시태그
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/boards/hashtag")
//    public ResponseEntity<ApiResponse> getHashtagList(@RequestParam(name = "hashtag") String hashtag) {
//        return ResponseEntity.ok(new ApiResponse("성공", "전체 게시물 리턴", boardService.getHashtagBoards(hashtag)));
//    }
//
//    // 게시글 작성
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("/boards/write")
//    public ResponseEntity<ApiResponse> write(@RequestBody PostDto postDto) {
//        //Member member = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
//        Member member = memberRepository.findById(1L).get();
//        //PostDto postDto = boardRequest.toDto();
//        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("성공", "글 작성 성공", boardService.write(postDto, member)));
//    }
//
//    // 게시글 수정
//    @ResponseStatus(HttpStatus.OK)
//    @PutMapping("/boards/update/{id}")
//    public ResponseEntity<ApiResponse> edit(@RequestBody PostDto postDto, @PathVariable("id") Integer id) {
//        Member member = memberRepository.findById(1L).get();
//        return ResponseEntity.ok(new ApiResponse("성공", "글 수정 성공", boardService.update(id, postDto)));
//    }
//
//
//    // 내부 클래스나 별도 파일로 정의할 수 있는 ApiResponse 클래스
//    private static class ApiResponse {
//        private String status;
//        private String message;
//        private Object data;
//
//        public ApiResponse(String status, String message, Object data) {
//            this.status = status;
//            this.message = message;
//            this.data = data;
//        }
//
//        // Getter and Setter
//        public String getStatus() {
//            return status;
//        }
//
//        public void setStatus(String status) {
//            this.status = status;
//        }
//
//        public String getMessage() {
//            return message;
//        }
//
//        public void setMessage(String message) {
//            this.message = message;
//        }
//
//        public Object getData() {
//            return data;
//        }
//
//        public void setData(Object data) {
//            this.data = data;
//        }
//    }
//}

import com.godseven.muntour.auth.MemberRepository;
import com.godseven.muntour.member.domain.Member;
import com.godseven.muntour.post.dto.PostDto;
import com.godseven.muntour.post.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final MemberRepository memberRepository;

    // 전체 게시글 조회
    @GetMapping("/boards")
    public ResponseEntity<ApiResponse> getBoards() {
        return ResponseEntity.ok(new ApiResponse("성공", "전체 게시물 리턴", boardService.getBoards()));
    }

    // 게시글 조회
    @GetMapping("/boards/{id}")
    public ResponseEntity<ApiResponse> getBoard(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(new ApiResponse("성공", "개별 게시물 리턴", boardService.getBoard(id)));
    }

    // 게시글 작성
    @PostMapping("/boards/write/{memberId}")
    public ResponseEntity<ApiResponse> write(@PathVariable("memberId") Long memberId, @RequestBody PostDto postDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse("성공", "글 작성 성공", boardService.write(postDto, member)));
    }

    // 게시글 수정
    @PutMapping("/boards/update/{id}/{memberId}")
    public ResponseEntity<ApiResponse> edit(@PathVariable("id") Integer id,
                                            @PathVariable("memberId") Long memberId,
                                            @RequestBody PostDto postDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        return ResponseEntity.ok(new ApiResponse("성공", "글 수정 성공", boardService.update(id, postDto)));
    }

    // 게시글 삭제
    @DeleteMapping("/boards/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable("id") Integer id) {
        boardService.delete(id);
        return ResponseEntity.ok(new ApiResponse("성공", "글 삭제 성공", null));
    }

    // 게시글 검색
    @GetMapping("/boards/search")
    public ResponseEntity<ApiResponse> searchBoards(@RequestParam("keyword") String keyword) {
        return ResponseEntity.ok(new ApiResponse("성공", "검색 결과 리턴", boardService.searchBoards(keyword)));
    }

    // 카테고리별 게시글 조회
    @GetMapping("/boards/category")
    public ResponseEntity<ApiResponse> getCategoryList(@RequestParam(name = "category") String category) {
        return ResponseEntity.ok(new ApiResponse("성공", "카테고리별 게시물 리턴", boardService.getCategoryBoards(category)));
    }

    // 해시태그별 게시글 조회
    @GetMapping("/boards/hashtag")
    public ResponseEntity<ApiResponse> getHashtagList(@RequestParam(name = "hashtag") String hashtag) {
        return ResponseEntity.ok(new ApiResponse("성공", "해시태그별 게시물 리턴", boardService.getHashtagBoards(hashtag)));
    }

    // ApiResponse 클래스
    private static class ApiResponse {
        private String status;
        private String message;
        private Object data;

        public ApiResponse(String status, String message, Object data) {
            this.status = status;
            this.message = message;
            this.data = data;
        }

        // Getter and Setter
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}
