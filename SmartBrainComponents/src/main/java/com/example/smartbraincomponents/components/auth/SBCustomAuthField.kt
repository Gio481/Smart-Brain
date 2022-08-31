package com.example.smartbraincomponents.components.auth

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.example.smartbraincomponents.R
import com.example.smartbraincomponents.databinding.SbCustomAuthFieldBinding
import com.example.smartbraincomponents.extension.getTextColor
import com.example.smartbraincomponents.extension.textChangedListener

class SBCustomAuthField @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyle: Int = 0,
) : ConstraintLayout(context, attrs, defStyle) {

    private val binding = SbCustomAuthFieldBinding.inflate(LayoutInflater.from(context), this, true)

    private var hint: String? = null
        set(value) {
            binding.authFieldName.text = value
            field = value
        }

    private var icon: Int = -1
        set(value) {
            binding.authIconImageView.setBackgroundResource(value)
            field = value
        }



    private var isPasswordHidden = true
    private var passwordIndicatorBackground: Int = -1
    private var passwordIndicatorSize: Int = 1
    private var passwordIndicatorMargin: Int = -1

    private var editTextType: EditTextType? = null
    private val passwordDuringSet = mutableListOf<String>()

    init {
        val typeArray = context.theme.obtainStyledAttributes(attrs,
            R.styleable.SBCustomAuthField,
            defStyle,
            defStyle
        )

        hint = typeArray.getString(R.styleable.SBCustomAuthField_hint)
        icon = typeArray.getResourceId(R.styleable.SBCustomAuthField_icon, -1)
        passwordIndicatorBackground =
            typeArray.getResourceId(R.styleable.SBCustomAuthField_passwordIndicatorBackground, -1)
        passwordIndicatorSize =
            typeArray.getDimensionPixelSize(R.styleable.SBCustomAuthField_passwordIndicatorSize, 1)
        passwordIndicatorMargin =
            typeArray.getDimensionPixelSize(R.styleable.SBCustomAuthField_passwordIndicatorMargin,
                1)
        editTextType =
            EditTextType.values()[typeArray.getInt(R.styleable.SBCustomAuthField_fieldType, 2)]
        typeArray.recycle()
        getAuthFieldType()
        setToggleButtonListener()
    }

    private fun setUpPasswords() {
        with(binding) {
            toggleButtonImageView.isVisible = true
            authEditText.textChangedListener(
                onTextChanged = { text, _, _, count ->
                    customCirclePasswordsLayout.isVisible = isPasswordHidden
                    authEditText.getTextColor(if (isPasswordHidden) R.color.transparent else R.color.grey)

                    if (count > passwordDuringSet.size) {
                        passwordDuringSet.add(text)
                        addPasswordView()
                        authEditText.isCursorVisible = false
                    }
                    if (count < passwordDuringSet.size) {
                        passwordDuringSet.removeAt(passwordDuringSet.size - 1)
                        removeView()
                    }
                }
            )
        }
    }

    private fun getAuthFieldType() {
        with(binding.authEditText) {
            when (editTextType) {
                EditTextType.Text -> {
                    inputType = InputType.TYPE_CLASS_TEXT
                    getTextColor(R.color.grey)
                }
                EditTextType.Email -> {
                    inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                    getTextColor(R.color.grey)
                }
                EditTextType.Password -> setUpPasswords()
                else -> inputType = InputType.TYPE_CLASS_NUMBER
            }
        }
    }

    private fun removeView() {
        with(binding) {
            if (passwordDuringSet.size - 1 >= 0) {
                customCirclePasswordsLayout.removeViewAt(passwordDuringSet.size - 1)
            } else {
                authEditText.isCursorVisible = true
                customCirclePasswordsLayout.removeAllViews()
            }
        }
    }

    private fun setToggleButtonListener() {
        with(binding) {
            toggleButtonImageView.setOnClickListener {
                isPasswordHidden = !isPasswordHidden
                toggleButtonImageView.setBackgroundResource(if (isPasswordHidden) R.drawable.ic_not_visible else R.drawable.ic_visible)
                customCirclePasswordsLayout.isVisible = isPasswordHidden
                authEditText.getTextColor(if (isPasswordHidden) R.color.transparent else R.color.grey)
                authEditText.isCursorVisible = !isPasswordHidden
            }
        }
    }

    private fun addPasswordView() {
        val passwordView = View(context)
        passwordView.setBackgroundResource(passwordIndicatorBackground)
        binding.customCirclePasswordsLayout.addView(passwordView, passwordIndicatorSize, passwordIndicatorSize)
        val lp = passwordView.layoutParams as LinearLayout.LayoutParams
        lp.marginStart = passwordIndicatorMargin
        passwordView.layoutParams = lp
    }

    enum class EditTextType(val value: Int) {
        Password(0),
        Email(1),
        Text(2)
    }
}