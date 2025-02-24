package org.example.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        var text by remember { mutableStateOf("") }
        var bottomSheetText by remember { mutableStateOf("") }

        var showBottomSheet by remember { mutableStateOf(false) }

        fun onTextChange(newValue: String) {
            text = newValue
        }

        fun onBottomSheetTextChange(newValue: String) {
            bottomSheetText = newValue
        }

        Box(Modifier.fillMaxSize()) {
            Column {
                Spacer(modifier = Modifier.height(24.dp))

                CustomTextField(
                    value = text,
                    onValueChange = { newText -> onTextChange(newText) },
                    placeholder = "Enter",
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { showBottomSheet = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                ) {
                    Text("Open Bottom Sheet")
                }
            }

            if (showBottomSheet) {
                CustomBottomSheet(
                    onDismiss = {
                        showBottomSheet = false
                    },
                    value = bottomSheetText,
                    onValueChange = { newBottomSheetText ->
                        onBottomSheetTextChange(
                            newBottomSheetText
                        )
                    },
                )
            }
        }
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    focusManager: FocusManager = LocalFocusManager.current,
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .height(36.dp),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
        maxLines = 1,
        decorationBox = { innerTextField ->
            if (value.isEmpty()) {
                Text(text = placeholder)
            }
            innerTextField()
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomSheet(
    onDismiss: () -> Unit,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        modifier = modifier.wrapContentSize(),
        sheetState = bottomSheetState,
        dragHandle = null,
    ) {
        Column(
            modifier = Modifier
                .background(White)
                .navigationBarsPadding(),
        ) {
            Spacer(modifier = Modifier.height(56.dp))
            CustomTextField(
                value = value,
                onValueChange = onValueChange,
                placeholder = "Enter",
            )
            Spacer(modifier = Modifier.height(28.dp))
        }
    }
}