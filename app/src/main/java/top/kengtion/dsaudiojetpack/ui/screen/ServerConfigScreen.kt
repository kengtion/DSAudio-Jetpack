package top.kengtion.dsaudiojetpack.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextInputSession
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import top.kengtion.dsaudiojetpack.data.ServerConfig

@Composable
fun ServerConfigScreen(config: ServerConfig?, saveConfig: (ServerConfig) -> Unit) {
    var domain by remember {
        mutableStateOf(config?.domain ?: "")
    }
    var userName by remember {
        mutableStateOf(config?.userName ?: "")
    }
    var userPwd by remember {
        mutableStateOf(config?.userPwd ?: "")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = domain,
            onValueChange = { value: String -> domain = value },
            maxLines = 1,
            label = { Text(text = "Domain") },
            textStyle = MaterialTheme.typography.body1,
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = userName,
            onValueChange = { value: String -> userName = value },
            maxLines = 1,
            label = { Text(text = "User Name") },
            textStyle = MaterialTheme.typography.body1,
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = userPwd,
            onValueChange = { value: String -> userPwd = value },
            maxLines = 1,
            label = { Text(text = "Password") },
            textStyle = MaterialTheme.typography.body1,
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            saveConfig(
                ServerConfig(
                    domain = domain,
                    userName = userName,
                    userPwd = userPwd,
                    cookieId = null
                )
            )
        }) {
            Icon(imageVector = Icons.Filled.Settings, contentDescription = "")
            Text(text = "Save Config")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun configPreview() {
    MaterialTheme {
        ServerConfigScreen(config = null) {
            Log.d(
                "Save",
                "{$it.userName}@{${it.domain}} saved"
            )
        }
    }
}