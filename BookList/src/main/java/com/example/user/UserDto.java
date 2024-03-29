package com.example.user;

import jakarta.validation.constraints.NotEmpty;

public class UserDto {
	
    @NotEmpty  // ユーザー名は空であってはならないというルール
    private String username;  // ユーザー名を保存するための場所

    @NotEmpty  // パスワードは空であってはならないというルール
    private String password;  // パスワードを保存するための場所


    // 以下は各値を取得するためのメソッド（ゲッター）です。
    public String getUsername() {
        return username;  // ユーザー名を返す
    }

    public void setUsername(String username) {
        this.username = username;  // ユーザー名を設定する
    }

    public String getPassword() {
        return password;  // パスワードを返す
    }

    public void setPassword(String password) {
        this.password = password;  // パスワードを設定する
    }


}
