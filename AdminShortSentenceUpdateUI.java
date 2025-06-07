package kr.ac.kopo.ui.adminUI;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.vo.ShortSentenceVO;

public class AdminShortSentenceUpdateUI extends BaseUI { // choice = "3223"

	@Override
	public void excute() throws Exception {
		clearScreen();
		title("짧은 문장 수정");

		int sentNo = scanInt("수정할 문장 번호를 입력하세요: ");
		ShortSentenceVO sentence = contentService.getShortSentenceByNo(sentNo);

		if (sentence == null) {
			System.out.println("해당 번호의 문장이 존재하지 않습니다.");
			Thread.sleep(1000);
			choice = "322";
			return;
		}

		System.out.println("현재 문장:");
		System.out.println("\"" + sentence.getContent() + "\"");

		while (true) {
			String newContent = scanStr("새 문장을 입력하세요 (0 입력 시 취소): ").trim();

			if ("0".equals(newContent)) {
				System.out.println("수정을 취소했습니다.");
				Thread.sleep(1000);
				choice = "322";
				return;
			}

			if (newContent.isEmpty()) {
				System.out.println("문장은 비어 있을 수 없습니다.");
				continue;
			}

			if (newContent.length() < 10) {
				System.out.println("문장이 너무 짧습니다. 10글자 이상 입력하세요.");
				continue;
			}

			// 입력 확인
			System.out.println("\n입력한 새 문장:");
			System.out.println("\"" + newContent + "\"");
			String confirm = scanStr("이 문장으로 수정하시겠습니까? (y/n): ");
			if (!confirm.equalsIgnoreCase("y")) {
				System.out.println("수정이 취소되었습니다.");
				Thread.sleep(1000);
				choice = "322";
				return;
			}

			boolean result = contentService.updateShortSentence(sentNo, newContent);
			if (result) {
				System.out.println("문장이 성공적으로 수정되었습니다.");
			} else {
				System.out.println("이미 존재하는 문장입니다.");
			}

			scanStr("엔터를 누르면 이전 화면으로 돌아갑니다...");
			choice = "322";
			return;
		}
	}
}
