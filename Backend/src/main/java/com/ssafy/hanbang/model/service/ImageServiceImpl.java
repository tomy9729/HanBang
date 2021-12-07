package com.ssafy.hanbang.model.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hanbang.model.ImageDto;
import com.ssafy.hanbang.model.mapper.ImageMapper;

@Service
public class ImageServiceImpl implements ImageService{

	@Autowired
	ImageMapper mapper;
	
	@Override
	public int saveImage(String encodedString, int bno, int hno) throws IOException {
		String imageName = UUID.randomUUID().toString()+".jpg";
		String imagePath = "E:\\SSAFY\\workspace\\07_spring\\hanbang8-2\\src\\main\\resources\\static\\image\\"+imageName;
		
		String data = encodedString.split(",")[1];
		byte[] imageBytes = DatatypeConverter.parseBase64Binary(data);
		
		try {
			BufferedImage bufImg = ImageIO.read(new ByteArrayInputStream(imageBytes));
			ImageIO.write(bufImg, "jpg", new File(imagePath));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		ImageDto imagedto = new ImageDto();
		imagedto.setImageno(0);
		imagedto.setBno(bno);
		imagedto.setHno(hno);
		imagedto.setImageName(imageName);
		imagedto.setImagePath(imagePath);
		
		return mapper.insert(imagedto);
	}

	@Override
	public String select(int imageno) {
		ImageDto image = mapper.select(imageno);
		System.out.println(image.getImagePath());
		File f = new File(image.getImagePath());
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		byte byteArray[] = new byte[(int)f.length()];
		try {
			fis.read(byteArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String imageString = Base64.encodeBase64String(byteArray);
		return "data:image/jpg;base64,"+imageString;
	}

	@Override
	public List<String> selectBybno(int bno) {
		List<ImageDto> imageDtos = mapper.selectBybno(bno);
		List<String> imageStringes = new ArrayList<String>();
		for(ImageDto imagedto : imageDtos) {
			String imageString = select(imagedto.getImageno());
			imageStringes.add(imageString);
		}
		return imageStringes;
	}

	@Override
	public List<String> selectByhno(int hno) {
		List<ImageDto> imageDtos = mapper.selectByhno(hno);
		List<String> imageStringes = new ArrayList<String>();
		for(ImageDto imagedto : imageDtos) {
			String imageString = select(imagedto.getImageno());
			imageStringes.add(imageString);
		}
		return imageStringes;
	}

	@Override
	public int deleteBybno(int bno) {
		return mapper.deleteBybno(bno);
	}

	@Override
	public int deleteByhno(int hno) {
		return mapper.deleteByhno(hno);
	}

	@Override
	public int getImageno() {
		return mapper.getImageno();
	}

	@Override
	public int update(ImageDto imagedto) {
		return mapper.update(imagedto);
	}

}
