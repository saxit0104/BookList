package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service // このクラスがサービス層のクラスであることを示します
public class UserService implements UserDetailsService { // UserDetailsServiceインターフェースを実装しています

    @Autowired // Springが自動的にUserRepositoryの実装を注入します
    private UserRepository userRepository;

    @Autowired // Springが自動的にPasswordEncoderの実装を注入します
    private PasswordEncoder passwordEncoder;

    @Override // UserDetailsServiceインターフェースのメソッドを上書きします
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username); // ユーザー名でユーザーを検索します
        if (user == null) {
            throw new UsernameNotFoundException("User not found"); // ユーザーが見つからない場合、例外をスローします
        }
        return (UserDetails) new UserPrincipal(user); // ユーザーが見つかった場合、UserPrincipalを作成し返します
    }
    
    public User findByUsername(String username) {
        return userRepository.findByUsername(username); // ユーザー名でユーザーを検索し返します
    }

    @Transactional // トランザクションを開始します。メソッドが終了したらトランザクションがコミットされます。
    public void save(UserDto userDto) {
        // UserDtoからUserへの変換
        User user = new User();
        user.setUsername(userDto.getUsername());
        // パスワードをハッシュ化してから保存
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        // データベースへの保存
        userRepository.save(user); // UserRepositoryを使ってユーザーをデータベースに保存します
    }


}
