package mvc.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import mvc.dto.Electronics;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;

/**
 * 전자제품에 관련된 기능을 담당할 클래스
 */

public class ElectronicsServiceImpl implements ElectronicsService {
	
	String [][] data = new String [][]{
		{"100","선풍기","35000","삼성 선풍기"},
		{"200","전자렌지","55000","잘 데워져요.."},
		{"300","에어컨","5500000","무풍 에어컨 너무 시원해"},
		{"400","냉장고","800000","LG 냉장고"},
		{"500","드라이기","9000","LG 드라이기"}
	}; // 최초의 초기치 데이터를 준비!! electronics에 저장 
	
	
	private static ElectronicsService instance = new ElectronicsServiceImpl(); 
    private static final int MAX_SIZE=10;
    List<Electronics> list = new ArrayList<Electronics>();
    
    /** 
     * 외부에서 객체 생성안됨. 
     * 생성자안에서 위에 2차원 배열의 데이터를 List에 추가하여
     * 초기치 데이터를 만든다.
     * 
     */
    private ElectronicsServiceImpl() {
        for (String [] s : data) {
        	Electronics elec = new Electronics(Integer.parseInt(s[0]), s[1], Integer.parseInt(s[2]), s[3]);
        	list.add(elec);
        }
      
    }
    
    public static ElectronicsService getInstance() {
		return instance;
	}

	@Override
	public void insert(Electronics electronics) throws ElectronicsArrayBoundsException, SearchNotFoundException {
		if (list.size() == MAX_SIZE) {
			throw new ElectronicsArrayBoundsException("더이상 등록할 수 없습니다.");
		}
		
		for (Electronics e : list) {
			if (e.getModelNo() == electronics.getModelNo()) {
				throw new SearchNotFoundException("이미 존재하는 제품번호입니다.");
			}
		}
		list.add(electronics);
	}

	@Override
	public List<Electronics> selectAll() {
		return list;
	}

	@Override
	public Electronics searchByModelNo(int modelNo) throws SearchNotFoundException {
		for (Electronics e : list) {
			if (e.getModelNo() == modelNo) {
				return e;
			}
		}
		throw new SearchNotFoundException("해당 제품이 존재하지 않습니다.");
	}

	@Override
	public void update(Electronics electronics) throws SearchNotFoundException {
		for (Electronics e : list) {
			if (e.getModelNo() == electronics.getModelNo()) {
				e.setModelDetail(electronics.getModelDetail());
				return;
			}
		}
		throw new SearchNotFoundException("해당 제품이 존재하지 않습니다.");
	}

	@Override
	public void delete(int modelNo) throws SearchNotFoundException {
		for (Electronics e : list) {
			if (e.getModelNo() == modelNo) {
				list.remove(e);
			}
		}
		throw new SearchNotFoundException("해당 제품이 존재하지 않습니다.");
		
	}
	
	@Override
	public void updatePrice(Electronics electronics) throws SearchNotFoundException {
		for (Electronics e : list) {
			if (e.getModelNo() == electronics.getModelNo()) {
				e.setModelPrice(electronics.getModelPrice());
				return;
			}
		}
		throw new SearchNotFoundException("해당 제품이 존재하지 않습니다.");
	}
	
	@Override
	public List<Electronics> getModelSortedByPrice() {
		List<Electronics> sortedList = new ArrayList<>(list);
		Collections.sort(sortedList, (a, b) -> (a.getModelPrice() - b.getModelPrice()));
		return sortedList;
	}
    
} // 클래스 끝 