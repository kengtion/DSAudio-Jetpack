package top.kengtion.dsaudiojetpack.data

data class ServerConfig(
    var domain: String,
    var userName: String,
    var userPwd: String,
    var cookieId: String?
) {
}