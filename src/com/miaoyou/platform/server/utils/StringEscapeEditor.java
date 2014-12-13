package com.miaoyou.platform.server.utils;

import java.beans.PropertyEditorSupport;

public class StringEscapeEditor extends PropertyEditorSupport {

	public StringEscapeEditor() {
		super();
	}

	@Override
	public void setAsText(String text) {
		if (text == null) {
			setValue(null);
		} else {
			text = text.replaceAll("<", "锛�1锟�7").replaceAll(">", "锛�1锟�7");
			setValue(text);
		}
	}

	@Override
	public String getAsText() {
		Object value = getValue();
		return value != null ? value.toString() : "";
	}
}