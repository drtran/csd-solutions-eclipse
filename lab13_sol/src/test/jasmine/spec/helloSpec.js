describe("Hello world", function() {
	it("says 'Hello, world!'", function() {
		expect(helloWorld()).toEqual("Hello world!");
	});
	it("says not 'Hello, world'", function() {
		expect(helloWorld()).toNotEqual("Hello world");
	});
});