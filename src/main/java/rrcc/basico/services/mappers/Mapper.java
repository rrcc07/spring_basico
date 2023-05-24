package rrcc.basico.services.mappers;

public interface Mapper<TypeSource, TypeResult> {
    TypeResult map(TypeSource source);
}
