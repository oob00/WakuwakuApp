package com.example.wakuwakuapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wakuwakuapp.api.ApiClient
import com.example.wakuwakuapp.api.ApiService
import com.example.wakuwakuapp.chat.ChatActivity
import com.example.wakuwakuapp.dto.LoginRequest
import com.example.wakuwakuapp.dto.LoginResponse
import com.example.wakuwakuapp.jwt.TokenManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class MainActivity : AppCompatActivity() {
    private lateinit var editTextId: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // dex file로 인한 SecurityExcepton 수정 코드
        val dexOutputDir: File = codeCacheDir
        dexOutputDir.setReadOnly()

        // Retrofit 초기화
        val apiService = ApiClient(applicationContext).client.create(ApiService::class.java)

        // 뷰 초기화
        editTextId = findViewById(R.id.editTextId)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)

        // 로그인 버튼에 클릭 리스너 설정
        buttonLogin.setOnClickListener {
            // 여기에 로그인 처리 코드를 작성하세요.
            val id = editTextId.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            val request = LoginRequest(id, password)
            apiService.login(request).enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.isSuccessful) {
                        val token = response.body()?.accessToken
                        // JWT 토큰 저장
                        token?.let { TokenManager.saveToken(this@MainActivity, it) }
                        // 로그인 성공 메시지 표시 또는 다음 화면으로 이동
                        Toast.makeText(this@MainActivity, "로그인 성공!\ntoken: $token", Toast.LENGTH_SHORT).show()

                        val intent = Intent(applicationContext, ChatActivity::class.java)
                        startActivity(intent)
                    } else {
                        // 로그인 실패 메시지 표시
                        Toast.makeText(this@MainActivity, "로그인 실패. 올바른 이메일과 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    // 네트워크 오류 메시지 표시
                    Toast.makeText(this@MainActivity, "로그인 실패. 네트워크 오류입니다.", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}