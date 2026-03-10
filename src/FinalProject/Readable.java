package FinalProject;

public class Readable extends Item implements Interact {

	protected String readText;
	
	public Readable(String name, String takeDescription, String inspectDescription, String setText) {
		super(name, takeDescription, inspectDescription);
		this.setReadText(setText);
	}
	
    @Override
    public void take(Player player, Room room, Game game) {
        System.out.println("There's no need to take that.");
    }

	@Override
	public void inspect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void use() {
		// TODO Auto-generated method stub

	}

	@Override
	public void read(Player player) {
		System.out.println(this.getReadText());

	}

	public String getReadText() {
		return readText;
	}

	public void setReadText(String readText) {
		this.readText = readText;
	}

}
