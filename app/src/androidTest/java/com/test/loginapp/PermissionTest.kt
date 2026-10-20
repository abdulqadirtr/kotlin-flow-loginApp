package com.test.loginapp

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import org.junit.Test
import java.util.regex.Pattern

class PermissionTest {

    @Test
    fun clickAllowPermission() {
        val device = UiDevice.getInstance(
            InstrumentationRegistry.getInstrumentation()
        )

        // 1. Regex pattern matching "Allow", "ALLOW", or "While using the app"
        val allowPattern = Pattern.compile(
            "(?i)allow|while using the app|only this time",
            Pattern.CASE_INSENSITIVE
        )

        // 2. Wait up to 5 seconds for the object to appear on screen
        val allowButton = device.wait(
            Until.findObject(By.text(allowPattern)),
            5000 // 5 seconds timeout
        )

        // 3. Click if found
        if (allowButton != null) {
            allowButton.click()
        } else {
            // Fallback: search by system resource ID common across Android versions
            val resourceIdButton = device.findObject(
                By.res("com.android.permissioncontroller:id/permission_allow_button")
            )
            resourceIdButton?.click()
        }
    }

    @Test
    fun openNotificationPanel() {
        val device = UiDevice.getInstance(
            InstrumentationRegistry.getInstrumentation()
        )
        device.openNotification()
    }


}
