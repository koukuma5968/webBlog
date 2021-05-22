package com.controller.builder;

import java.util.HashMap;

import com.param.ParamBean;
import com.util.FileUtil;
import com.util.RequestCipher;

public enum ContentDownloadBuilderType implements BuilderInterface {

	CONTENT("contentBean") {
		@Override
		public Object createBody(ParamBean param) {

			String content = FileUtil.getDocumentroot()+ FileUtil.contentPass + param.getPath() + param.getFilename();

			HashMap<String, String> contentBean = new HashMap<String, String>();

			RequestCipher cipr = new RequestCipher();

			contentBean.put("content", content);
			contentBean.put("encParam", cipr.encode(param));
			contentBean.put("contentname", param.getName());
			contentBean.put("descriptionimg", FileUtil.contentPass + param.getPath() +  FileUtil.description + "Image.png");
			contentBean.put("descriptionmsg", FileUtil.getDescriptionMsg(param.getPath(), "text.txt"));

			return contentBean;
		}
	};

	private ContentDownloadBuilderType(String key) {
		this.key = key;
	}

	private String key;

	public String getKey() {
		return this.key;
	}

}
