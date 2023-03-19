package top.kengtion.dsaudiojetpack.data

data class ServerConfig(
    val domain: String,
    val userName: String,
    val userPwd: String,
    var cookieId: String?
) {
}