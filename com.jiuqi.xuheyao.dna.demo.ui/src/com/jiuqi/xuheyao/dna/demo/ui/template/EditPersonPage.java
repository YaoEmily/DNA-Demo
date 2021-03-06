package com.jiuqi.xuheyao.dna.demo.ui.template;

import com.jiuqi.dna.core.situation.MessageListener;
import com.jiuqi.dna.core.situation.MessageTransmitter;
import com.jiuqi.dna.core.situation.Situation;
import com.jiuqi.dna.ui.template.launch.TemplateWindow.CloseMessage;
import com.jiuqi.dna.ui.wt.events.ActionEvent;
import com.jiuqi.dna.ui.wt.widgets.Composite;
import com.jiuqi.dna.ui.wt.widgets.Form;
import com.jiuqi.dna.ui.wt.widgets.MessageDialog;

public class EditPersonPage<TControls extends EditPersonPageControls> extends Form<EditPersonPageControls> {

	public EditPersonPage(Composite parent) {
		super(parent);
		
		getContext().regMessageListener(PersonInfoEditMsg.class, new MessageListener<PersonInfoEditMsg>() {

			@Override
			public void onMessage(Situation context, PersonInfoEditMsg message,
					MessageTransmitter<PersonInfoEditMsg> transmitter) {
				controls.txt_name.setText(message.name);
				controls.spr_age.setSelection(message.age);
				
			}
		});
		
		getContext().regMessageListener(PersonInfoMsg.class, new MessageListener<PersonInfoMsg>() {

			@Override
			public void onMessage(Situation context, PersonInfoMsg message,
					MessageTransmitter<PersonInfoMsg> transmitter) {
				controls.txt_name.setText(message.name);
				controls.spr_age.setSelection(message.age);
				
			}
		});
	}

	protected void on_btn_cancel_Action(ActionEvent actionEvent) {
		// 关闭窗口，发送消息
		getContext().bubbleMessage(new CloseMessage());
	}

	protected void on_btn_save_Action(ActionEvent actionEvent) {
		// 获取页面中的信息
		String name = controls.txt_name.getText();
		if(name.length()>10)
		{
			MessageDialog.alert("姓名过长，长度不允许大于10");
			return;
		}
		
		PersonInfoFinishMsg msg = new PersonInfoFinishMsg();
		msg.name = name;
		msg.age = controls.spr_age.getSelection();
		
		getContext().bubbleMessage(msg);
	}

}