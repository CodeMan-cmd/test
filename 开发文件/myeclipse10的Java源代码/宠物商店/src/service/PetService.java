package service;

import java.util.List;

import dao.PetDao;
import dao.PetOwnerDao;
import daoimpl.PetDaoimpl;
import daoimpl.PetOwnerDaoimpl;
import entity.Pet;
import entity.PetOwner;
import entity.PetStore;;
public class PetService {
	PetDao pd=new PetDaoimpl();
	PetOwnerDao pod=new PetOwnerDaoimpl();
	public void PetStore(){
		System.out.println("�����̵�����");
		System.out.println("���Գ�������");
		pwtwakeup();
		System.out.println("���г�������");
		petowenrwakeup();
		System.out.println("�����̵�����");
		petstorewakeup();
	}
	
	private void petstorewakeup() {
		System.out.println("*********************************");
		List<entity.PetStore> list=pd.selectAllPetStore();
		for(PetStore pet1 : list){
			System.out.println(pet1.getId()+"\t"+pet1.getName()+"\t"+pet1.getPassword());
		}
	}

	private void petowenrwakeup() {
		System.out.println("*********************************");
		List<PetOwner> list=pd.selectAllPetOwner();
		System.out.println("���\t��������");
		for (PetOwner pet2 : list) {
			System.out.println(pet2.getId()+"\t"+pet2.getName());
		}
	}

	private void pwtwakeup() {
		System.out.println("*********************************");
		System.out.println("���\t��������");
		List<Pet> list=pd.selectAllPet();
		for (Pet pet : list) {
			System.out.println(pet.getId()+"\t"+pet.getName());
			
		}
	}
}
