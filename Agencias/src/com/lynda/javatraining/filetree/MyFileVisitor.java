package com.lynda.javatraining.filetree;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)
			throws IOException {
		System.out.println("Just visited " + dir);
//		return super.postVisitDirectory(dir, exc);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
			throws IOException {
		System.out.println("About to visit " + dir);
//		return super.postVisitDirectory(dir, exc);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		if (attrs.isRegularFile()) {
			System.out.print("Regular File: ");
		}
		System.out.println(file);
		return FileVisitResult.CONTINUE;
//		return super.visitFile(arg0, arg1);
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)
			throws IOException {
		System.err.print(exc.getMessage());
//		return super.visitFileFailed(arg0, arg1);
		return FileVisitResult.CONTINUE;
	}
	
	

}
